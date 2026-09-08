#include <vector>
#include <map>
#include <iostream>

using namespace std;

int solution(vector<int> nums)
{
    int size = nums.size() / 2;
    map<int, int> m;
    
    for (auto n : nums) {
        m[n]++;
    }
    
    return m.size() < size ? m.size() : size;
}