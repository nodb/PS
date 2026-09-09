#include <string>
#include <iostream>
#include <deque>

using namespace std;

bool solution(string s)
{    
    deque<char> q;
    
    for (auto a : s) {
        if (a == '(') {
            q.push_back('(');
        } else if (a == ')') {
            if (q.size() != 0 && q.back() == '(') {
                q.pop_back();
            } else {
                return false;
            }
            
        }
    }
    
    if (q.size() != 0) {
        return false;
    }
    
    return true;
}