/**
 * Definition for undirected graph.
 * struct UndirectedGraphNode {
 *     int label;
 *     vector<UndirectedGraphNode *> neighbors;
 *     UndirectedGraphNode(int x) : label(x) {};
 * };
 */
class Solution {
public:
    UndirectedGraphNode *cloneGraph(UndirectedGraphNode *node) {
        if(node == NULL)
            return node;
        if(hash.find(node) == hash.end()){
            hash[node] = new UndirectedGraphNode(node->label);
            for(auto i : node->neighbors){
                newNode->neighbors.push_back(cloneGraph(i));
            }
        }
        else{
            return hash[node];
        }
        return hash[node];
    }
private:
    unordered_map<UndirectedGraphNode*, UndirectedGraphNode*> hash;
};
