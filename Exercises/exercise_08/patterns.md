#Patterns
In this program the following patterns were used:
- Visitor
- Composite
- Iterator

##Usage
###Composite
is a structural design pattern that lets you compose objects into tree structures and allow clients to
work with these structures as if they were individual objects

Were are treating all different `Addresses` and `Groups` through a common interface named `Component`. The client uses
all tree elements only through the Component interface. The Address does not have any children and so does all the
work by itself. Groups on the other hand can have children (other Components, Groups and Addresses), but do not know
the type of children. They delegate work to the children, then sum up the results before returning it to the client.
More specific: The `InputReader` class does have a method named `compose()` which does this sum up.

**Benefits**: Now, probably the greatest benefit of this approach is that you do not need to care much about the concrete
objects that make a tree. Whether it is a single `Address` or sophisticated `Group`, you treat it through a generic
interface. And the structure handles passing the requests down by itself.

###Iterator
is a behavioral design pattern that lets you access the elements of an aggregate object sequentially without exposing
its underlying representation.

We have an interfaced `Iterator` and a specific class `Search`. The Search class is responsible for searching through
the address-group composition. It takes some Attributes and looks for matches. It uses an iterator and fills its results
to linked lists.

**Benefits**:The main idea is to extract the traversal method of a collection into a separate object.
The iterator encapsulate traversal details such as current position and how much elements it still needs to go over.
This allows several iterators to go over the same collection independently. The collection does not even notice that
someone goes through its elements. Moreover, if you need a special way to traverse a collection, you can just create a
new iterator class, without touching the collection's code.

###Visitor
is a behavioral design pattern that lets you define a new operation without changing the classes of the objects on which
it operates.

**Benefits:** Normally we would need to add an export method for each type and then go over every Component, executing
this method for each.

In our program the `Visitor` interface declares the common interface for all types of visitors. It declares a set of
visiting methods that accept various Context Components as parameters. The methods may have the same names in languages
that support overloading, but their parameter types must be different.

Concrete Visitors (`PrintVisitor` and `ExportVisitor`) implements all the operations described in the common Visitor
interface. Each concrete visitor represents a single behavior.

The `Component` interface declares a method for accepting Visitors (`accept(v: Visitor)`).
