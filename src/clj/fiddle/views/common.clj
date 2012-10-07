(ns fiddle.views.common
  (:use [noir.core :only [defpartial]]
        [hiccup.page :only [html5 include-css include-js]]))

(defpartial layout [& content]
  (html5
    [:head
      [:title "Hello World"]
      (include-css "/css/bootstrap.css")
      (include-css "/css/theme.css")
      (include-js "//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js")
      (include-js "/js/editor/ace.js")
      (include-js "/js/main.js")]
    [:body
      [:div.navbar.navbar-fixed-top
        [:div.navbar-inner
          [:div.container-fluid
            [:a.brand "cljsFiddle"]]]]
      content]))