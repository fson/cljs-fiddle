(ns fiddle.views
  (:require
    [hiccup
      [page :refer [html5 include-js include-css]]
      [element :refer [javascript-tag unordered-list]]
      [def :refer [defelem]]]))

; When using {:optimizations :whitespace}, the Google Closure compiler combines
; its JavaScript inputs into a single file, which obviates the need for a "deps.js"
; file for dependencies.  However, true to ":whitespace", the compiler does not remove
; the code that tries to fetch the (nonexistent) "deps.js" file.  Thus, we have to turn
; off that feature here by setting CLOSURE_NO_DEPS.
;
; Note that this would not be necessary for :simple or :advanced optimizations.
(defn- include-clojurescript [path]
  (list
    (javascript-tag "var CLOSURE_NO_DEPS = true;")
    (include-js path)))

(defn example-source []
  "(defn fib
  ([] (concat [0 1] (fib 0 1)))
  ([a b] (lazy-cons (+ a b) (fib b (+ a b)))))")

(def preview-modes ["Page" "Source" "Output"])

(defelem nav-pills [names]
  (let [li-elems (vec (map #(vector :li {} [:a %]) names))]
    [:ul.nav.nav-pills (seq (assoc-in li-elems [0 1 :class] "active"))]))

(defn index-page []
  (html5
    [:head
      [:title "Hello World"]
      (include-css "/css/bootstrap.css")
      (include-css "/css/theme.css")
      (include-js "//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js")
      (include-js "/js/editor/ace.js")
      (include-clojurescript "/js/main.js")]
    [:body
      [:div.navbar.navbar-fixed-top
        [:div.navbar-inner
          [:div.container-fluid
            [:a.brand "cljsFiddle"]]]]
      [:div.left.column
        [:div.editor (example-source)]]
      [:div.right.column
        (comment (nav-pills preview-modes))
        [:iframe.preview {:sandbox true}]]]))
