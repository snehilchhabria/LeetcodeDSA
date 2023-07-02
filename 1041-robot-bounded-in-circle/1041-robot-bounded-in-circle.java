class Solution {
    public boolean isRobotBounded(String instructions) {
        
        int[][] dir = {{0,1}, {-1,0}, {0,-1}, {1,0}};
        int rotate = 0;
        int x = 0, y =0; //starting point
        
        for(int i= 0; i<instructions.length(); i++){
            if(instructions.charAt(i) == 'L'){
                rotate = (rotate + 1)%4; //left turn
            }
            else if(instructions.charAt(i) == 'R'){
                rotate = (rotate + 3)%4; // right turn
            }
            else{ //if char is 'G' then add the value to it from dir as only 1 unit is to added
                x= x + dir[rotate][0];
                y = y + dir[rotate][1];
            }
        }
        
        //1. if x and y = 0 it means it never moved and stayed there 
        //2. if rotate is greater than 0 it means it will rotate and will eventually come at origin 
        //as it repeats forevr so it is bound to come to origin if it hasnt stayed at dir[0](which means facing
        //towards north which it faces initially)
        return x == 0 && y == 0 || rotate > 0;
    }
}