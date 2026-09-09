#include <string>
#include <vector>
#include <deque>
#include <iostream>

using namespace std;

int solution(vector<int> priorities, int location) {
    deque<pair<int, int>> dq;
    
    for (int i = 0; i < priorities.size(); i++) {
        dq.push_back({i, priorities[i]});
    }
    
    vector<pair<int, int>> v;
    for (int l = 0; l < priorities.size(); l++) {
        int max = 0;
        int loc = -1;
        for (int i = 0; i < dq.size(); i++) {
            int n = dq.front().second;
            dq.push_back(dq.front());
            dq.pop_front();
            if (n > max) {
                max = n;
                loc = i;
            }
        }
        for (int i = 0; i < loc; i++) {
            dq.push_back(dq.front());
            dq.pop_front();
        }
        v.push_back(dq.front());
        dq.pop_front();
    }
    
    for (int i = 0; i < priorities.size(); i++) {
        if (v[i].first == location) {
            return i + 1;
        }
    }
    
    return -1;
}