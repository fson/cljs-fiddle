(ns fiddle.views.load
  (:use [jayq.core :only [on bind data $ append]]
        [crate.core :only [html]]
        [crate.form :only [text-field]]))

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
      [:button.btn.btn-primary "Load"]]]))

(defn init-load []
  (append ($ :body) (.modal ($ (modal)))))