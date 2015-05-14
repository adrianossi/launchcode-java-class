PSET 3
======

Here are some good references to check out before/while you work on this pset:

* [What is an interface?](https://docs.oracle.com/javase/tutorial/java/concepts/interface.html)
* [Java documentation for interfaces](https://docs.oracle.com/javase/tutorial/java/IandI/createinterface.html)
* [Interfaces vs. Inheritance] (http://stackoverflow.com/questions/8531292/why-to-use-interfaces-multiple-inheritance-vs-interfaces-benefits-of-interface)
* [Java Exception Lesson](https://docs.oracle.com/javase/tutorial/essential/exceptions/)
* [Exceptions tutorial](http://www.tutorialspoint.com/java/java_exceptions.htm)
* [HashMap tutorial](http://tutorialswithexamples.com/java-map-and-hashmap-tutorial-with-examples/)
* [Reading a file with scanner](http://www.javaprogrammingforums.com/file-input-output-tutorials/339-reading-file-line-line-using-scanner-class.html)

#Cryptography

Recall from CS50 that you [did a little bit of cryptography](http://cdn.cs50.net/2015/spring/psets/2/pset2/pset2.html#hail_caesar) using Caesar's Cipher and Vignere's Cipher. You will be creating those ciphers again, this time in Java.

First, create an interface called `Encodable`. This interface should have the following members:

* encode
* decode

#Implementing your interface

Once you are satisfied with your interface, you should implement it. Create a `Caesar` class and a `Vignere` class that implement your interface.

For the Caesar cipher, you should create two additional methods: `createEncodeMap` and `createDecodeMap`. These methods should create `HashMaps` with a mapping of each character of the alphabet to the character it would be encoded/decoded to. For example, if created a Caesar Cipher with a key of 1, the encode map could be used like this:

`Map<String, String> encodeMap = c.createEncodeMap();
System.out.println(encodeMap.get("a");//would print "b"`

The decode map would behave in a similar fashion.

You may assume that everything is in lower or upper case to keep things simple. You can also assume that there will not be any spaces or other special characters.

#Putting it all together

Once you have completed and thoroughly tested your code, notify the instructor.

#Extra

Extend your code to read in a file and encode/decode it (or both!). Make sure to handle Exceptions appropriately using try/catch.