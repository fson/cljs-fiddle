(ns fiddle.views.home
  (:require [fiddle.views.common :as common])
  (:use [noir.core :only [defpage defpartial]]))

(defn example-source []
  "(defn fib
  ([] (concat [0 1] (fib 0 1)))
  ([a b] (lazy-cons (+ a b) (fib b (+ a b)))))")

(def preview-modes ["Page" "Source" "Output"])

(defpartial nav-pills [names]
  (let [li-elems (vec (map #(vector :li {} [:a %]) names))]
    [:ul.nav.nav-pills (seq (assoc-in li-elems [0 1 :class] "active"))]))

(defpage "/" []
  (common/layout
    [:div.left.column
      [:div.editor (example-source)]]
    [:div.right.column
      (comment (nav-pills preview-modes))
      [:iframe.preview {:sandbox true}]]))