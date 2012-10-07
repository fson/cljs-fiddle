(ns fiddle.server
  (:require [noir.server :as server]))

(server/load-views-ns 'fiddle.views)

(defn -main [& m]
  (let [mode (keyword (or (first m) :dev))
        port (Integer. (get (System/getenv) "PORT" "3000"))]
    (server/start port {:mode mode
                        :ns 'fiddle})))