#include <bits/stdc++.h>
using namespace std;

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    int a[9], b[7], sum;
    for(int i=0;i<9;i++) cin>>a[i];
    for(int i=0;i<8;i++){
        for(int j=i+1;j<9;j++){
            sum=0;
            for(int k=0, l=0;k<9;k++) if(k!=i&&k!=j) b[l++]=a[k];
            for(int k=0;k<7;k++) sum+=b[k];
            if(sum==100) break;
        }
        if(sum==100) break;
    }
    sort(b,b+7);
    for(int i=0;i<7;i++) cout << b[i] << "\n";
}