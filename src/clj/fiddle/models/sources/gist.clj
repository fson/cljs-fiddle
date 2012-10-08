(ns fiddle.models.sources.gist
  (use [tentacles.gists :only [specific-gist]])
  (:import [java.net URL]))

(defn parse-url [url]
  (let [path (.getPath (URL. url))]
    (second (re-find #"^/([A-Za-z0-9]+)" path))))

(defn fetch [url]
  (when-let [id (parse-url url)]
    (map val (:files (specific-gist id)))))