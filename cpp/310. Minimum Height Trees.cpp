class Solution {
public:
    struct Node{
        unordered_set<int> neighbor;
        bool isLeaf()const{return neighbor.size() == 1;}
    };
    vector<int> findMinHeightTrees(int n, vector<pair<int, int>>& edges) {
        vector<int> buffer1;
        vector<int> buffer2;
        vector<int> *p1 = &buffer1;
        vector<int> *p2 = &buffer2;
        if(n == 1){
            buffer1.push_back(0);
            return buffer1;
        }
        if(n == 2){
            buffer1.push_back(0);
            buffer1.push_back(1);
            return buffer1;
        }
        //build the graph
        vector<Node> nodes(n);
        for(auto e : edges){
            nodes[e.first].neighbor.insert(e.second);
            nodes[e.second].neighbor.insert(e.first);
        }
        //find all leaves
        for(int i = 0; i < n; i++){
            if(nodes[i].isLeaf())
                buffer1.push_back(i);
        }
        //remove leaves level by level
        while(1){
            for(int n : *p1){
                for(int m : nodes[n].neighbor){
                    nodes[m].neighbor.erase(n);
                    if(nodes[m].isLeaf())
                        p2->push_back(m);
                }
            }
            if(p2->empty())
                return *p1;
            p1->clear();
            swap(p1, p2);
        }
    }


};
