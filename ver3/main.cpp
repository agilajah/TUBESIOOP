#include "makhluk.h"
#include "board.h"
#include "point.h"
#include "manager.h"
#include "viewer.h"
#include <unistd.h>
#include <iostream>
#include <thread>
#include <termios.h>
using namespace std;

Board board;
Manager worldManager(100,&board);
Viewer view(&board);
bool stop,paused,stepByStep = false;

void nonblock()
{
    struct termios ttystate;
    tcgetattr(STDIN_FILENO, &ttystate);
    ttystate.c_lflag &= ~ICANON;
    ttystate.c_cc[VMIN] = 1;
    tcsetattr(STDIN_FILENO, TCSANOW, &ttystate);
 }

void loop() {
        while (!stop) {
            if (!paused) {
                view.displayToScreen();
                worldManager.moveAll();
            }
            else if (stepByStep) {
                worldManager.moveAll(); 
                view.displayToScreen();
                stepByStep = false;
            }
        }
}

int main() {
    char cc;

    nonblock();
    thread t(loop);	
    do {
        cc = getchar();
        switch(cc) {
            case 'p'    :   paused = true;
                            cout << " | Program paused... (Press 'c' to continue or 's' for step by step execution) ";
                            break;
            case 'f'    :   if(paused) view.displayToFile();
                            break;
            case 'c'    :   paused = false;
                            break;
            case 's'    :   stepByStep = true;
                            break;
            case 'e'    :   stop = true;
                            t.join();
                            break;
            case ','    :   view.increaseRefreshRate();
                            break;
            case '.'    :   view.decreaseRefreshRate();
                            break;
        }
    } while (!stop);
    cout << endl<< "Program exited.." << endl;
	return 0;
}