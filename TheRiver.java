		import java.util.Random;
public class TheRiver {

	public static void main(String[] args) 
	{
		
		Random rand = new Random();
		final int NUM_OF_BEARS = 5;
		final int NUM_OF_FISH = 5;
		final int RIVER_SIZE = 5000;
		final int TIME = 10;
		int n; //random number
		int newPosition;
		boolean foundHome = false;
		
			
			Animal[] river = new Animal[RIVER_SIZE];
			for (int i = 0; i < river.length; i++){
				river[i] = null;	
			}
		
		
		/*
		 * @This section of the code will generate fish and bears randomly 
		 * across the array.
		 */
			for (int i = 0; i < NUM_OF_BEARS; i++) //Generate the fish 
			{  
				foundHome = false;
				while (!foundHome)
				{
					n = rand.nextInt(RIVER_SIZE);
					if (river[n] == null)
					{
						river[n] = new Bear();
						foundHome = true;
					}
				}
			}
		
		


		
		for (int i = 0; i < NUM_OF_FISH; i++) //Generate the fish 
		{  
			foundHome = false;
			while (!foundHome)
			{
				n = rand.nextInt(RIVER_SIZE);
				if (river[n] == null)
				{
					river[n] = new Fish();
					foundHome = true;
				}
			}
		}
		
		
		/*
		 * This segment of the code is for movement
		 */
		for (int j = 0; j < TIME; j++)
		{
			for (int i = 0; i < river.length; i++)
			{
				if (river[i] != null)
				{
					/*
					 * This deals wish bear movement
					 */
					if (river[i].idGet() == 1)
					{   //If the animal is a bear
						 n = rand.nextInt(2)-1;   // Determine bear's movement
						 newPosition = i + n;
						 if (newPosition < 0)
						 {
							 newPosition = 0;
						 }
						 else if (newPosition > river.length)
						 {
							 newPosition = river.length;
						 }
						if (river[newPosition] == null)
						{   //Is the new position empty?
							river[newPosition] = river[i];
							river[i] = null;
						 }
						else  if (river[newPosition].idGet() == 2)
						{
							 river[newPosition] = river[i];
							 river[i] = null;		
						 } 
						 else if (river[newPosition].idGet() == 1)
						 {
							//Mating behavior goes here
							 
							 foundHome = false;
								while (!foundHome)
								{
									n = rand.nextInt(RIVER_SIZE);
									if (river[n] == null)
									{
										river[n] = new Bear();
										foundHome = true;
									}
								}
						 }
					}	
					
					
					/*
					 * This segment of the code deals with fish movement.
					 */
					else if (river[i].idGet() == 2)
					{
						n = rand.nextInt(2)-1;   // Determine fish's movement
						 newPosition = i + n;
						 if (newPosition < 0)
						 {
							 newPosition = 0;
						 }
						 else if (newPosition > river.length)
						 {
							 newPosition = river.length;
						 }
						 if (river[newPosition] == null)
						 {
								river[newPosition] = river[i];
								river[i] = null;
						 }
						 else  if (river[newPosition].idGet() == 1)  //If the fish encounters bear
						 { 
							 river[i] = null;		
						 }
						 else if (river[newPosition].idGet() == 2){
							 foundHome = false;
								while (!foundHome)
								{
									n = rand.nextInt(RIVER_SIZE);
									if (river[n] == null)
									{
										river[n] = new Fish();
										foundHome = true;
									}
								}
						 }
						 
					}	
					//If null check comes to here, does nothing
				}
			}
			for (int i = 0; i < river.length; i++){
				if (river[i] == null){
					System.out.print("~");
				}
				else if (river[i].idGet() == 1){
					System.out.print("|Bear|");
				}
				else {
					System.out.print("|Fish|");
				}
				
				
			}
			System.out.println("");


			
		}
		
		


	}
}


