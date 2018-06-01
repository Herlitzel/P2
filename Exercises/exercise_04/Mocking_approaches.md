Paragraph about two Mocking approaches:

1. Using Mockito
  This way is very flexible and allows to simulate a specific behavior very
  quick and within just a few lines. The Framework works for every java class
  and is therefore flexible. Of course, one is limited to the functions the
  framework gives. So if you want a very specific mock on one class, it may be
  better to create a custom one. But To mock a range of classes in development,
  Mockito provides fairly enough functions I guess.

2. Creating custom mocks
  This way is, of course, very flexible and controllable. You can specify
  the behavior you want without needing extra features. But you have to specify
  every behavior specifically and for every class to mock. This can also be a
  strength if you have to mock one class and use it very specific. But again,
  for a wider and more flexible Use, a framework is the better choice.

In a Software in development, both methods are used for testing. Mockito in
the wider Range and the custom one in specific cases. I think in testing,
a certain experience is required, too in order to distinguish what is the best
for a specific test.
