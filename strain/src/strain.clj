(ns strain)

(defn retain
  "Keeps the items in coll for which (pred item) returns true."
  [pred coll]
  ;; function body
  (filter pred coll))

(defn discard
  "Removes the items in coll for which (pred item) returns true."
  [pred coll]
  ;; function body
  (remove pred coll))
