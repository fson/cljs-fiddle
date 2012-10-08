# cljs-fiddle

_Note! cljsFiddle is in a very early stage of development
where many essential features are not implemented yet._

cljsFiddle is a simple web application for editing ClojureScript source code and
previewing it in similar fashion to JsFiddle[1] does for JavaScript.

## Running the App

Set up and start the server like this:

    $ lein deps
    $ lein cljsbuild once
    $ lein run

Now, point your web browser at `http://localhost:3000`,
and see cljs-fiddle in action.

[1]: http://jsfiddle.net/