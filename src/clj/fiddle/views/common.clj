(ns fiddle.views.common
  (:use [noir.core :only [defpartial]]
        [hiccup.page :only [html5 include-css include-js]]))

(defpartial layout [scripts & content]
  (html5
    [:head
      [:title "cljsFiddle"]
      (include-css "/css/bootstrap.css")
      (include-css "/css/theme.css")
      (include-js "//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js")
      (include-js "/js/bootstrap.min.js")
      (map include-js scripts)]
    [:body
      [:div.navbar.navbar-fixed-top
        [:div.navbar-inner
          [:div.container-fluid
            [:a.brand "cljsFiddle"]
            [:div.navigation
              [:button.btn {:data-action :load} "Load"]]]]]
      content]))