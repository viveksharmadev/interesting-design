// https://leetcode.com/problems/design-snake-game/
class SnakeGame {
    
    class Position{
        int x;
        int y;
        public Position(int x,int y){
            this.x = x;
            this.y = y;
        }
        public boolean equals(Position p){
            return this.x==p.x && this.y == p.y ;
        }
        
        public int hashcode(Position p){
            return Objects.hash(p.x,p.y);
        }
    }
    int len;
    int rows ,cols;
    
    int[][] food;
    LinkedList<Position> snake;
   
    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        this.rows = height;
        this.cols = width;
        this.food = food;
   
        snake = new LinkedList<Position>();
        snake.add(new Position(0,0));
        len = 0;
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
    	//if(len>=food.length) return len;
    
        Position cur = new Position(snake.get(0).x,snake.get(0).y);
        
        switch(direction){
        case "U": 
            cur.x--;  break;
        case "L": 
            cur.y--; break;
        case "R": 
            cur.y++;   break;
        case "D": 
            cur.x++;   break;
        }
        
        if(cur.x<0 || cur.x>= rows || cur.y<0 || cur.y>=cols) return -1;
        

        for(int i=1;i<snake.size()-1;i++){
            Position next = snake.get(i);
            if(next.equals(cur)) return -1;	       
        }
        snake.addFirst(cur);     
        if(len<food.length){
            Position p = new Position(food[len][0],food[len][1]);	        
            if(cur.equals(p)){	            
                len++;
            }
        }
        if(snake.size()>len+1) snake.removeLast();
       
        return len;
    }
    
}
