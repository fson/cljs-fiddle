(ns fiddle.views.load
  (:use [fiddle.util :only [react-on]]
        [jayq.core :only [on bind data $ append xhr]]
        [crate.core :only [html]]
        [crate.form :only [text-field]]))

(defn create-project []
  (let url (.val ($ "input[name='url']"))
    (xhr [:post "/projects"] {:url url})))

(defmulti handler keyword)

(defmethod handler :create [_]
  (create-project))

(defn modal []
  (html [:div.modal
    [:div.modal-header
      [:button.close {:data-dismiss "modal"} "×"]
      [:h3 "Load"]]
    [:div.modal-body
      [:p "Load code from a Github Gist. Url:"]
      [:form.form-inline
        (text-field
          {:placeholder "https://gist.github.com/1"
           :class "input-xlarge"}
          :url)]]
    [:div.modal-footer
      [:button.btn {:data-dismiss "modal"} "Cancel"]
      [:button.btn.btn-primary {:data-action "create"} "Load"]]]))

(defn init-load []
  (let [elem (.modal ($ (modal)))]
    (react-on elem :click handler)
    (append ($ :body) elem)))