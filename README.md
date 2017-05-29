# Mano-Computer
Description: This program simulates the instructions of Mano’s Computer
Package: manoComputer
Classes: Divided into three classes:- Descriptions.java, Instructions.java, and Mano_Computer.java

Description.java:
This class contains the description of each instruction. For example the ADD instruction adds memory to the AC, and this class holds that description so that if the ADD and other Descriptions(AND LDA STA etc.) are is needed in the Instructions class, it is called from here. The Descriptions are divided into functions so to make calling them easy.

Instructions.java:
This class first creates a random function that creates random values to fill the 4096 locations of the memory. Then we have different functions for the Memory and Instructions from T1 through T6 for direct and indirect memory addresses.

Mano_Computer.java:
This class is the contains main and that shows the output.

<img src='http://i.imgur.com/7D4ew0I.png' title='Video Walkthrough' width='' alt='Sample Output' />

