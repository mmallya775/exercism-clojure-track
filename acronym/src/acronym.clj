(ns acronym
  (:require [clojure.string :as str]))

(defn acronym
  "Converts phrase to its acronym."
  [s]
  ;; function body
  (->> s
       (re-seq #"[A-Z']+[a-z']*|[a-z']+")
       (map (comp first clojure.string/upper-case))
       (clojure.string/join)))



(re-seq #"[A-Z]+[a-z]*|[a-z]+" "Halley's Commet")
