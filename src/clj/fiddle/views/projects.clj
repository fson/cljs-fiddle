(ns fiddle.views.projects
  (:use [noir.core :only [defpage]]
        [hiccup.form :only [form-to submit-button text-field]]) ; temp
  (:require  [fiddle.models.project :as projects]
             [noir.response :as response]
             [fiddle.views.common :as common]))  ;temp

(defn resp
  ([content] (response/json content))
  ([status content] (response/status status (resp content))))

(defpage "/projects" []
  (common/layout []
    [:div.content
      (form-to {:class "form-inline"} [:post "/projects"]
        (text-field {:placeholder "http://"} :url)
        (submit-button {:class :btn} "Add project"))]))
  ; (json (for
  ;         [n (range 0 10)]
  ;         {:name (str "Project " (inc n))
  ;          :url "http://dummy.url.com"})))

(defpage [:post "/projects"] {:keys [url]}
  (if-not url
    (resp 400 {:message "Missing url"})
    (if-let [project (projects/create! url)]
      (resp project)
      (resp 500 {:message "Creating the project failed"}))))