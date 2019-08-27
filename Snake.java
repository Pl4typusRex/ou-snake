import ou.*;
/**
 * partial class Snake - TMA02 Q1.
 * 
 * @author (Sophie Wallace) 
 * @version (1.0)
 */
public class Snake
{
   // Declaring instance variables
   private Circle head; // provided
   private Circle body;
   private Circle tail;

   /**
    * Constructor for objects of class Snake
    */
   public Snake(int startX, int startY, Circle aHead, Circle aBody, Circle aTail)
   {
      // initialise instance variables
      head = aHead; // provided
      head.setXPos(startX); // provided
      head.setYPos(startY); // provided
      head.setDiameter(10); // provided
      
      body = aBody;
      body.setXPos(startX);
      body.setYPos(startY);
      body.setDiameter(8);
      
      tail = aTail;
      tail.setXPos(startX);
      tail.setYPos(startY);
      tail.setDiameter(6);
      
      setColour(OUColour.RED);
   }

   /**
    * sets the colour of head, body and tail all to the argument colour.
    */
   private void setColour(OUColour colour)
   {
      head.setColour(colour); // provided
      body.setColour(colour);
      tail.setColour(colour);

   }

   /**
    * helper method to return x position of head
    */
   private int getHeadXPos() // provided
   {
      return head.getXPos();
   }

   /**
    * helper method to return y position of head
    */
   private int getHeadYPos()
   {
      return head.getYPos();
   }
   
   /**
    * helper method to return x position of body
    */
   private int getBodyXPos()
   {
      return body.getXPos();
   }

   /**
    * helper method to return y position of body
    */
   private int getBodyYPos()
   {
      return body.getYPos();
   }
   
   /**
    * provided
    * return true if the argument represents a valid x-position for a head
    */
   private boolean checkX(int anXPos) // check room to make move
   {
      if ((anXPos >= 0) && (anXPos <= (250 - head.getDiameter()))) // constants only happen in Unit 7
      {
         return true;
      }
      else
      {
         return false;
      }
      //alternative one-line version
      // return ((anXPos >= 0) && (anXPos <= (250 - head.getDiameter())));
   }

   /**
    * return true if the argument represents a valid y-position for a head
    */
   private boolean checkY(int aYPos) // check room to make move
   {
      if ((aYPos >= 0) && (aYPos <= (350 - head.getDiameter())))
      {
         return true;
      }
      else
      {
         return false;
      }
   }
   
   /**
    * provided, but won't compile til earlier parts are completed.
    * once you have completed the methods you are asked to write in
    * parts c and d you can uncomment the body of the method.
    * 
    * if the new position is valid, move the snake so that its head is in the given position
    * move the body to where the head was, and the tail to where the body was.
    * Delay after each move.
    * otherwise
    * leave position unchanged
    * output appropriate message
    */
   private void moveTo(int newHeadX, int newHeadY) // provided
   {
       int oldHeadX = getHeadXPos(); 
       int oldHeadY = getHeadYPos();
       int oldBodyX = getBodyXPos();
       int oldBodyY = getBodyYPos();
       if (checkX(newHeadX) && checkY(newHeadY))
       {
          head.setXPos(newHeadX);
          head.setYPos(newHeadY);
          delay(100);
          body.setXPos(oldHeadX);
          body.setYPos(oldHeadY);
          delay(100);            
          tail.setXPos(oldBodyX);
          tail.setYPos(oldBodyY);
          delay(100);            
       }
       else
       {
          System.out.println("Snake cannot cross boundary!");
       }      
   }

   /**
    * Calculates the new position of the head (one head diameter to the right)
    * Moves snake to that position if possible
    */
   public void right()
   {
      int newHeadXPos = getHeadXPos() + 10;
      int newHeadYPos = getHeadYPos();
      moveTo(newHeadXPos,newHeadYPos);
   }
   
   /**
    * Calculates the new position of the head (one head diameter to the left)
    * Moves snake to that position if possible
    */
   public void left()
   {
      int newHeadXPos = getHeadXPos() - 10;
      int newHeadYPos = getHeadYPos();
      moveTo(newHeadXPos,newHeadYPos);
   }
   
   /**
    * Calculates the new position of the head (one head diameter up)
    * Moves snake to that position if possible
    */
   public void up()
   {
      int newHeadXPos = getHeadXPos();
      int newHeadYPos = getHeadYPos() - 10;
      moveTo(newHeadXPos,newHeadYPos);
   }
   
   /**
    * Calculates the new position of the head (one head diameter down)
    * Moves snake to that position if possible
    */
   public void down()
   {
      int newHeadXPos = getHeadXPos();
      int newHeadYPos = getHeadYPos() + 10;
      moveTo(newHeadXPos,newHeadYPos);
   }
   
   /**
    * provided
    * Causes execution to pause by time number of milliseconds
    * You can use this method without needing to understand how it works
    */
   public void delay(int time)
   {
      try
      {
         Thread.sleep(time); 
      }
      catch (Exception e)
      {
         System.out.println(e);
      } 
   }

   /**
    * provided
    * return a random integer between 1 and 4 inclusive
    * You can use this method without needing to understand how it works
    */
   public int randomInteger() 
   {
      java.util.Random r = new java.util.Random();
      return r.nextInt(4) + 1;
   }

   /**
    * Moves the snake object in a random direction for 100 moves
    * Uses a random number between 1 and 4 to determine right, left, up or down movement
    */
   public void randomWalk()
   {
      int count = 0;
      
      while (count < 100)
      {
         int x = randomInteger();
         
         if(x == 1)
         {
            right();
         }
         else if (x == 2)
         {
            left();
         }
         else if (x == 3)
         {
            up();
         }
         else if (x == 4)
         {
            down();
         }
         else
         {
            System.out.println("Error with random number");
         }
         
         count++;
      }      
   }
   
   /**
    * Returns the snake to its home position
    */
   public void home()
   {
      int xPos = getHeadXPos() + 10;
      int yPos = getHeadYPos() + 10;
      /* if the x position of the head is between 115 and 135 
       * then it's already within one head diameter of 125
       * so the x position doesn't need to change
       */
      while (xPos < 115)
      {
         right();
         xPos = getHeadXPos() + 10; // sets x to the new position
      }
      while (xPos > 135)
      {
         left();
         xPos = getHeadXPos() + 10; // sets x to the new position
      }
      
      /* if the y position of the head is between 165 and 185 
       * then it's already within one head diameter of 175
       * so the y position doesn't need to change
       */
      while (yPos < 165)
      {
         down();
         yPos = getHeadYPos() + 10; // sets y to the new position
      }
      while (yPos > 185)
      {
         up();
         yPos = getHeadYPos() + 10; // sets y to the new position
      }
   }
   
}
