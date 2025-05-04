(ns raindrops)

(defn convert
  "Converts a number to its corresponding string of raindrop sounds."
  [num]
  ;; function body
  (if (not (or (= (mod num 3) 0)
               (= (mod num 5) 0)
               (= (mod num 7) 0)))
    (str num)
    (let [start-str (str "")
          by-three  (if (= (mod num 3) 0)
                      (str start-str "Pling")
                      (str start-str nil))
          by-five  (if (= (mod num 5) 0)
                     (str by-three "Plang")
                     (str by-three nil))
          by-seven  (if (= (mod num 7) 0)
                      (str by-five "Plong")
                      (str by-five nil))]
      by-seven)))


