#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */   
    int MAX = 1000000;
    int[] types = new int[MAX + 1];
     int TOP = (int) sqrt(MAX);
    for (int k = 2; k <= TOP; k += 2) {
      int b2 = 2;
      while (true) {
        int product = k * (k + b2);
        if (product > MAX)
          break;
        types[product]++;
        b2 += 2;
      }
    }
    
    int result = new int[MAX+1];
    for (int i = 1; i <= MAX; i++) {
      if (types[i] >= 1 && types[i] <= 10) {
        result[i] = result[i-1] + 1;
      } else {
        result[i] = result[i-1];
      }
    }
    int t;
    cin >> t;
    int k;
    for (int i = 0; i < t; i++) {
    	cin >> k;
    	cout << result[k];
    }

    return 0;
}

