package iD.FinalProject.src.ChooseYourOwnAdventure;

import java.util.*;
public class ChooseYourOwnAdventure 
{
	public static void print(String s)
	{
		System.out.println(s);
	}


	public static void main(String[]args)
	{
		print("Your boat has crashed on an island. You can see a beach, mountain, field, forest, and lake.");
		print("Rules: keep all entries lowercase. If you are going somewhere, use 'go to (place you are going to)'You have hunger, tiredness, and thirst meters");
		//game variables
		String room = "beach";
		boolean wood = false;
		boolean radio = false;
		//It takes 15 actions without dying to win. Each action takes one hour in a 3 hour day. Night doesn't exist
		int hours = 0;
		int thirst = 0;
		int tired = 0;
		int hunger = 0;
		Random rng = new Random();
		Scanner input= new Scanner(System.in);
		//Game Loop
		while(hours < 15)
		{
			if(hunger > 6)
			{
				print("You need to eat.");
			}
			else if(hunger > 12)
			{
				print("You died of starvation");
				return;
			}
			if(tired > 6)
			{
			print("you are rather tired...");																																																																																																																																																																																												
			}
			if(thirst > 6)
			{
				print("You're getting thirsty...");
			}
			else if(thirst > 9)
			{
				print("You died of dehydration");
				return;
			}
			//beach
			if(room.equals("beach"))
			{
				print("What do you want to do? You are at the beach. There is a mountain, forest, field, and lake.");
				int r = rng.nextInt(2);
				if(r == 0)
				{
					print("There are also berries here. THEY ARE NOT POISONOUS");
				}
				String action = input.nextLine();
				if (tired > 13)
				{
					print("You are too tired...");
				}
				else if(action.equals("go to mountain"))
				{
					room = "mountain";
				}
				else if(action.equals("go to forest"))
				{
					room = "forest";
				}
				else if(action.equals("go to lake"))
				{
					room = "lake";
				}
				else if(action.equals("go to field"))
				{
					room = "field";
				}
				else if(action.contains("berries"))
				{
					if(r == 0)
					{
						hunger = 0;
						print("You ate the berries");
					}
					else
					{
						print("There are no berries here.");
					}
				}
				//add hour
				hours = hours + 1;
				thirst = thirst + 1;
				tired = tired + 1;
				hunger = hunger + 1;
			}
			if(room.equals("field"))
			{
				print("This is a big field... Maybe I can find something... You can either explore, or go back.");
				String action = input.nextLine();
				if (tired > 13)
				{
					print("You are too tired...");
				}
				else if(action.equals("explore"))
				{
					print("I think I see some metal... Hmm... *You found a radio*");
					radio = true;
				}
				else if(action.equals("go back"))
				{
					room = "beach";
				}
				//add hour
				hours = hours + 1;
				thirst = thirst + 1;
				tired = tired + 1;
				hunger = hunger + 1;
			}
			//mountain
			if(room.equals("mountain"))
			{
				print("You can either climb the mountain, or go to: beach, lake, or forest.");	
				String action = input.nextLine();
				if (tired > 13)
				{
					print("You are too tired...");
				}
				else if(action.contains("mountain"))
				{
					room = "mountain peak";
				}
				else if(action.equals("go to beach"))
				{
					room = "beach";
				}
				else if(action.equals("go to forest"))
				{
					room = "forest";
				}
				else if(action.equals("go to lake"))
				{
					room = "lake";
				}
			 
			//add hour
			hours = hours + 1;
			thirst = thirst + 1;
			tired = tired + 1;
			hunger = hunger + 1;
		}
		//hill
		if(room.equals("hill"))
		{
			print("You are on the hill. You can go to the beach, mountain, lake, or forest.");
			if(radio == true)
			{
				print("You can also radio for help");
			}
			String action = input.nextLine();
			if (tired > 13)
			{
				print("You are too tired...");
			}
			else if(action.equals("go to beach"))
		    {
		    	room = "beach";
		    }
			else if(action.equals("go to mountain"))
			{
				room = "mountain";
			}
			else if(action.equals("go to lake"))
			{
				room = "lake";
			}
			else if(action.equals("go to forest"))
			{
				room = "forest";
			}
			else if(action.contains("radio"))
			{
				print("You radio someone who comes and gets you.");
				break;
			}
			//add hour
			hours = hours + 1;
			thirst = thirst + 1;
			tired = tired + 1;
			hunger = hunger + 1;
		}
		//cave
		if(room.equals("cave"))
		{
			print("You found a CAVE!!!!!! You can use this cave as shelter. You can go back to the forest, light a fire, or stay here. ");
			String action = input.nextLine();
            if(tired > 6)
            {
            	print("You can also sleep.");
            }
            if (tired > 13)
			{
				print("You are too tired...");
			}
            else if(action.contains("stay"))
			{
				room = "cave";
			}
			else if(action.contains("sleep"))
			{
				tired = 0;
				print("You slept.");
			}
			else if(action.contains("back"))
			{
				room = "forest";
			}
			else if(action.contains("fire"))
			{
				if(wood == true)
				{
					print("You made a fire!");
				}
				else
				{
					print("You dum-dum, you've got no wood.");
				}
			}
				//add hour
				hours = hours + 1;
				thirst = thirst + 1;
				tired = tired + 1;
				hunger = hunger + 1;
		}
		//lake
		if(room.equals("lake"))
		{
            print("Welcome to the lake. You drink some water or go to the mountain, beach, forest, or jump in the lake.");
            String action = input.nextLine();
            if (tired > 13)
			{
				print("You are too tired...");
			}
            else if (action.equals("go to beach"))
            {
            	room = "beach";
            }
            else if(action.contains("drink"))
            {
            	thirst = 0;
            	print("You drank water.");
            }
            else if(action.equals("go to forest"))
            {
            	room = "forest";
            }
            else if(action.equals("go to mountain"))
            {
            	room = "mountain";
            }
            else if(action.contains("jump"))
            {
            	room = "inLake";
            }
            //add hour
			hours = hours + 1;
			thirst = thirst + 1;
			tired = tired + 1;
			hunger = hunger + 1;
		}
		//inLake is for the player to jump in and drown
		if(room.equals("inLake"))
		{
			print("You drowned. GAME OVER.");
			return;
		}
		//forest
		if(room.equals("forest"))
		{
         print("You are in the forest. You can pick up wood, or go to the mountain, beach, lake, or a CAVE!");
         String action = input.nextLine();
         if (tired > 13)
			{
				print("You are too tired...");
			}
         else if(action.equals("go to cave"))
         {
        	 room = "cave";
         }
         else if(action.equals("go to mountain"))
         {
        	 room = "mountain";
         }
         else if(action.equals("go to beach"))
         {
        	 room = "beach";
         }
         else if(action.equals("go to lake"))
         {
        	 room = "lake";
         }
         else if (action.contains("wood"))
         {
        	 wood = true;
        	 print("You got wood.");
         }
         //add hour
			hours = hours + 1;
			thirst = thirst + 1;
			tired = tired + 1;
			hunger = hunger + 1;
		}
		//mountain peak
		if(room.equals("mountain peak"))
		{
			print("A Yeti eats you. GAME OVER");
			return;
		}
	}

	print("You have been rescued! You Won!");



}
}
