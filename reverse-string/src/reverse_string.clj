(ns reverse-string)

(defn reverse-string
  "Reverses the given string"
  [s]
  ;; function body
  (reduce #(str %2 %1) ""  s))


