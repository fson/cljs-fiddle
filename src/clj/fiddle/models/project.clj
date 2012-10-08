(ns fiddle.models.project
  (:require [fiddle.models.sources.gist :as gist])
  (:import [java.net URL]))

(defmulti fetch
  (fn [url] (.getHost (URL. url))))

(defmethod fetch "gist.github.com" [url]
  (gist/fetch url))

(defmethod fetch :default [url]
  (throw (IllegalArgumentException.
    (str "I don't know how to fetch from " url))))

(defn create!
  "Creates a project from given attributes."
  [url]
  (let [files (fetch url)]
    {:id url
     :files files}))