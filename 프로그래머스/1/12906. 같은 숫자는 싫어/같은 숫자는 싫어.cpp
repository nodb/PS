#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(vector<int> arr) 
{
    vector<int> answer;
    int prev = 10;
    for (auto a : arr) {
        if (a != prev) {
            answer.push_back(a);
            prev = a;
        }
    }

    return answer;
}