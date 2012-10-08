(ns fiddle.views.home
  (:require [fiddle.views.common :as common])
  (:use [noir.core :only [defpage]]))

(defpage "/" []
  (common/layout ["/js/editor/ace.js" "/js/main.js"]
    [:div.content.left.column
      [:div.editor]]))