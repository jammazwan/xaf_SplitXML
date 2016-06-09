### SplitXML NOTES:

There are so many approaches to splitting a message body that I found it helpful to break it into different projects.

### Common to all x__Split___ Projects

There are often many different ways to split even just one kind of body. This is where Camel's "does everything to anything" approach can be a bit confusing to the newbie. You may eventually want to learn 20 great approaches, but right now you just want one specific approach that's going work for your use case.

So each Split___ example project has to show, and/or cross reference, working code that makes each of the relevant approaches work, quickly and without a bunch of cruft.

**All Split___ example projects** were inspired by a grep of **'.split('** on **'*Test.java'** in the actual **camel-core** code base - hundreds of examples. A good place to start, if you want a more in depth exploration of anything, not just '.split('.

You will probably want to read [**this doc on Camel's site**](http://camel.apache.org/splitter.html) before doing much with splits. It took me a week to find it, and ended up being one of the best sources.

### XML Split High Level Options

 * xpath
 * tokenizeXML
 * xtokenize
 * using String.split() instead???
 * Converting to List<MyObject> first?
 
### Are XML splits irrelevant?

Claus Isben covers no **split().xpath(** or **split().xtokenize(** or **split().tokenizeXML(** code examples in his [new, yet unfinished book code](https://github.com/camelinaction/camelinaction2). Is this an oversight? Or an indication of preferred direction to parse with beans and @XPath annotations? 

I am not sure so I just covered what is shown in **camel-core** test code.
 
### xpath:
 
Xpath is probably the most likely option and the only one covered by the code in this project. There are 3 examples.

Missing is a working example of using xpath to peel out xml from files with multiple xml root elements. Still not even sure if that exists. Also see below.
 
### tokenizeXML:
 
'tokenizeXML()' is an alternative to xpath and two examples are included in this x__project.
 
### xtokenize:
 
'xtokenize()' is for more complex use cases than tokenizeXML but I will leave it to you to research that on your own. See [the splitter page](http://camel.apache.org/splitter.html) for more information.

### Using String.split() for xml?
 
Hah! String.split() for XML??? Seems ridiculous, huh? No, not proposing that you start using a regex...
 
A typical use case might be, where each line of a file is an entire chunk of standalone xml. See [employees.xml](https://github.com/jammazwan/jammazwan.shared/blob/master/src/main/resources/data/employees.xml) So you are really just using String split to split up a file into separate lines, then processing each line as an xml message.

To see this approach in action go to [xaj_SplitFile](https://github.com/jammazwan/xaj_SplitFile)

There are other approaches to solving this same problem, such as reading in the a [file as a list with xml root options](https://github.com/jammazwan/jammazwan.shared/blob/master/src/main/resources/data/employees.xml). They are not covered here, or at least not yet, primarily because I haven't figured out how to get one working yet.
 
### Converting to List<MyObject> first

You probably wouldn't use this approach unless you already had chunked up your XML into objects in a previous endpoint.

So all we are doing here is pointing out that sometimes this happens, and when it does, you know what to do.
 
 
 