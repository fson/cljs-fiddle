# cljs-fiddle

This is a simple web application for editing ClojureScript source code and
previewing it in similar fashion to JsFiddle[1] does for JavaScript.

## Running the App

Set up and start the server like this:

    $ lein deps
    $ lein cljsbuild once
    $ lein ring server-headless 3000

Now, point your web browser at `http://localhost:3000`,
and see cljs-fiddle in action.

[1]: http://jsfiddle.net/