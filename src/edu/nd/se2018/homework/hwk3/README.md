Michael Wang
September 15, 2018
Professor Huang
Assignment 3 - Observer Design Pattern

In my design, I had a main application OceanExplorer which ran my program using JavaFX. One of its features is the ability to customize the number of pirate ships, dimensions, and islands in only this class, and then the rest of the program should carry out normally, you don't have to change anything else in other classes. This makes altering the inputs to the program very easy and convenient. By making a map class separate, I'm able to easily set a variable within ship and pirates which each have their own copy of the map which records which tiles are islands and water. This way ships and pirates will know which tiles they can and can not go into. The observer design patter was convenient as well because I just needed to update the ships location whenever I moved it, and then all of the pirates will receive this information and then act upon it. In this case, the pirates moved accordingly and tried to close the distance to the main ship. Had I not implemented the observer pattern, then I would have had to update each new pirates's location accordingly based on where they were at rather than having each pirate observe the location of the ship. 

In order to support new functionality such as a reset button, I would have to make my screen larger and add a button which called OceanExplorer's overwritten start function which would then create an entirely new map, pirates, and islands. While I don't know the exact syntax for "re-calling" start again within OceanExplorer, I would make the button simply call start or launch of the main program again which would reset everything and randomly create islands, pirates, and ship position conveniently. In order to add images of islands, I would implement this in my OceanMap class and instead of drawing forestgreen tiles, I would add an image of an island. In order to add images of waves, I would implement this in my OceanMap class as well and instead of drawing blue tiles I would add an image of a wave and then update my main scene of course.

Overall, I liked the fact that each class had its own purpose. The ship was solely based on moving and making sure the pirate knew where it was. The pirate's sole purpose was to try to catch up to the ship. And the OceanMap class provided a way for both of the ship and pirate class to check to make sure they didn't run into the islands and stuck within bounds. OceanExplorer took care of starting the program and attaching observers to the ship all the while providing basic information to each class such as dimensions, bordersize, pirates, islands, and oceanMap. 