(ns resistor-color)

(def colors
  ;; definition value
  ["black" "brown" "red" "orange" "yellow"
   "green" "blue" "violet" "grey" "white"])

(defn color-code
  "Returns the numerical value associated with the given color"
  [color]
  (-> (zipmap colors (range))
      (get color)))
