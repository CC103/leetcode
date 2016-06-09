#include<iostream>
#include<stdlib.h>
using namespace std;
class Solution {
public:
	int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int x1 = 0, x0 = 0;
		int y1 = 0, y0 = 0;
		if (C <= G && C >= E){
			x1 = C;
			if (A < E)
				x0 = E;
			else
				x0 = A;
		}
		else if (G <= C && G >= A){
			x1 = G;
			if (E < A)
				x0 = A;
			else
				x0 = E;
		}
		if (H <= D && H >= B){
			y1 = H;
			if (B > F)
				y0 = B;
			else
				y0 = F;
		}
		else if (D <= H && D >= F){
			y1 = D;
			if (F > B)
				y0 = F;
			else
				y0 = B;
		}
		int area = (x1 - x0) * (y1 - y0);
		cout << "area" << "	" << area << endl;
		int area0 = (D - B) * (C - A);
		cout << "area0" << "	" << area0 << endl;
		int area1 = (H - F) * (G - E);
		cout << "area1" << "	" << area1 << endl;
		int areaTotal = area0 + area1 - area;
		cout << "areaTotal" << "	" << areaTotal << endl;
		return areaTotal;
	}
};
int main(){
	Solution s;
	int area = s.computeArea(-2, -2, 2, 2, 3, 3, 4, 4);
	system("pause");
	return 0;
}
