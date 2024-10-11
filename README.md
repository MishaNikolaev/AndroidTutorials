**SOLID in practice**

AndroidTutorials/solid/app/src/main/java/com/example/solid/patterns/

**Single responsibility principle**

We have an IOManager interface and it contains a lot of different methods that should be separated.

```  Kotlin
interface IOManager {
    fun saveFile()

    fun readFile()

    fun saveApi()

    fun readApi()

    fun saveToDb()

    fun readFromDb()
}
```
The principle of single responsibility is broken.

The best desicion in this situation is create few interfaces (like db, api and file) for different methods.

It will be better to add many interfaces which depends on their own methods.

``` Kotlin
interface  FileIOManager{
    fun saveFile()
    fun readFile()
}

interface  ApiOManager{
    fun saveApi()
    fun readApi()
}

interface  DbIOManager{
    fun saveToDb()
    fun readFromDb()
}
```


At all: the principle of single responsibility is as follows:
we do not have the right to make different methods in the same
class or interface.

**Open closed principle**

Let's try to add one more type of notification (for example SMS)

```
enum class Notification {
    PUSH_NOTIFICATION, EMAIL //Try to add element in enum like SMS
}

class NotificationService {

    fun sendNotification(notification: Notification) {
        when (notification) {
            Notification.PUSH_NOTIFICATION -> {
                // send push notification
            }

            Notification.EMAIL -> {
                // send email notification
            }

            /*Notification.SMS -> {
                // send sms notification
            }
             */
        }
    }
}
```
So we've had a change in class. This is antagonize our principle. We need another realization.

``` Kotlin
interface Notification {
    fun send()
}

class PushNotification : Notification {
    override fun send() {
        // send push notification
    }
}

class EmailNotification : Notification {
    override fun send() {
        // send email notification
    }
}

class SMSNotification : Notification {
    override fun send() {
        // send sms notification
    }
}

class NotificationService {

    fun sendNotification(notification: Notification) {
        notification.send()
    }
}
```

Now our class hasn't changed and principle hasn't broken.

**Open closed principle**

We have this situation:

```Kotlin
open class Rectangle {
    protected var width: Int = 0
    protected var height: Int = 0

    open fun set_Width(width: Int) {
        this.width = width
    }

    open fun set_Height(height: Int) {
        this.height = height
    }

    fun calculateSquare(): Int {
        return width * height
    }
}

class Square : Rectangle() {

    override fun set_Width(width: Int) {
        super.set_Width(width)
        setSide(width)
    }

    override fun set_Height(height: Int) {
        this.width = height
        this.height = height
    }

    private fun setSide(side: Int) {
        super.width = side
        super.height = side
    }
}


class SquareCalculator {
    fun calculateSquare(shape: Rectangle): Int {
        return shape.calculateSquare()
    }
}


fun main() {
    val rectangle = Rectangle()
    rectangle.set_Height(5)
    rectangle.set_Width(10)

    val square = Square()
    square.set_Height(5)
    square.set_Width(10)

    val squareCalculator = SquareCalculator()
    squareCalculator.calculateSquare(rectangle)
    println("Rectangle square = ${squareCalculator.calculateSquare(rectangle)}")
    println("Square square = ${squareCalculator.calculateSquare(square)}")
}
```
In our class, rectangle and square are completely different classes. And we inherit from rectangle to square class. We are getting completely different functions.  So we can't do that. 

```Kotlin
interface HasSquare {
    fun calculateSquare(): Int
}

class Rectangle(private val width: Int, private val height: Int) : HasSquare {
    override fun calculateSquare(): Int {
        return width * height
    }
}

class Square(private val side: Int) : HasSquare {

    override fun calculateSquare(): Int {
        return side * side
    }
}

class SquareCalculator {
    fun calculateSquare(squareable: HasSquare): Int {
        return squareable.calculateSquare()
    }
}
```
In this situation we shouldn't inherit. Each class is another entity.


**Interface segregation priciple**

next...
