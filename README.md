# Generic classes

<h2>Description</h2>
<b>
  Define a generic class on example of a linked list and how to use it to store different types of data.
</b> 
</br></br>
<p>
  The application is designed to store four different types of data at
  using collections belonging to one generic class. The generic class implements
  dynamic data structure in the form of a bidirectional linked list.
  Each item stored in the collection will be accessed using
  index (number of item in the list) and identifier, which will be a unique value of any
  numeric type (it can be e.g. Byte, Short, Integer, Double, etc.).
</p>
<p>
Four collections are created that define and store the following objects:
</p>
<ol>
  <li><b>identifier:</b> Integer, <b>content:</b> String (e.g. 1 - "Ala", 2 - "Ela", 3 - "Ola")</li>
  <li><b>identifier:</b> Byte, <b>content:</b> Integer (e.g. 1 – 1990, 2 – 2010, 3 – 2021)</li>
  <li><b>identifier:</b> Long, <b>content:</b> CPerson (defined class)</li>
  <li><b>identifier:</b> Integer, <b>content:</b> ImageIcon (image file)</li>
</ol>

<h2>Languages and Utilities Used</h2>

- <b>Java</b> (SE 21 LTS)
- <b>Java Swing</b> (GUI)

<h2>Environments Used</h2>

- <b>IntelliJ IDEA 2023.3.3</b>

<h2>Program walk-through:</h2>

<p align="center">
Launching the application: <br/>
<img src="https://i.imgur.com/zbHBVbH.png" width="80%" alt ="App"  width="80%"/>
<br />
<br />
Adding contents to collections:  <br/>
<img src="https://i.imgur.com/Msa1Y6O.png" alt="AddingToCollections" width="80%"/>
<br />
<br />
Searching values from collection: <br/>
<img src="https://i.imgur.com/AblyjQL.png" width="80%" alt="EndOfGame"/>
<br />
<br />
Exception handling: <br/>
<img src="https://i.imgur.com/IlpJDDd.png" width="80%" alt="EndOfGame"/>
<br />
  
<h2>Functionality</h2>
<p>
  <ul>
    <li>Possibility to assign values ​​and add another item to each collection</li>
    <li>The elements of each collection are displayed on the screen using a list component</li>
    <li>Searching for a specific element and displaying its value using the index or identifier have been implemented into the collection (1)</li>
    <li>Possibility to enter personal data required by the CPerson constructor and an identifier, create an object and add it to the collection.</li>
    <li>Ability to select a graphic file (raster image) by the user (JFileChooser) and add it with its ID to the collection</li>
    <li>Collection items are displayed on the screen using a list component.</li>
    <li>An appropriate rendering engine object was created in such a way that the list would display images (inheriting from javax.swing.DefaultListCellRenderer).</li>
  </ul>
</p>
