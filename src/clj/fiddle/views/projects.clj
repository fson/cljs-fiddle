(ns fiddle.views.projects
  (:use [noir.core :only [defpage]]
        [noir.response :only [json]]))

(defpage "/projects" []
  (json (range 0 10)))