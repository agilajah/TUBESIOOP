#include "makhluk.h"
#include "board.h"
#include "point.h"
#include "manager.h"
#include "viewer.h"
#include <unistd.h>
#include <iostream>
#include <thread>
#include <termios.h>
#define NB_ENABLE 1
#define NB_DISABLE 0

using namespace std;






Board board;
Manager worldManager(100,&board);
Viewer view(&board);
bool stop,paused,stepByStep = false;

void nonblock(int state)
{
    struct termios ttystate;
 
    //get the terminal sstate
    tcgetattr(STDIN_FILENO, &ttystate);
 
    if (state==NB_ENABLE)
    {
        //turn off canonical mode
        ttystate.c_lflag &= ~ICANON;
        //minimum of number input read.
        ttystate.c_cc[VMIN] = 1;
    }
    else if (state==NB_DISABLE)
    {
        //turn on canonical mode
        ttystate.c_lflag |= ICANON;
    }
    //set the terminal attributes.
    tcsetattr(STDIN_FILENO, TCSANOW, &ttystate);
 }

void  loop() {
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
    nonblock(NB_ENABLE);

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

