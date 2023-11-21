# arKATZanoid
An Arkanoid game made throughout a semster with 3 differenet levels and 1 extra level that won a level competition 

Running using ANT:
 ```sh
ant compile
ant run -Dargs=""
```
In -Dargs you can write a sequence of numbers from the numbers 1 2 3 4.
Examples:
 ```sh
ant run -Dargs="1 2 3 4"
ant run -Dargs="4 3 2 1"
ant run -Dargs="1 1 1 1"
ant run -Dargs="4"
ant run -Dargs="2 4 3 1 2 1 3 4 1 2"
```
Anything that is not 1-4 will be ignored.
