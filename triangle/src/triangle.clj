(ns triangle)

(defn- triangle?
  "Checks if a give set of sides represent a triangle or not."
  [a b c]
  (let [greater-than-zero (and (> a 0)
                               (> b 0)
                               (> c 0))
        compare-three-sides (and (>= (+ a b) c)
                                 (>= (+ b c) a)
                                 (>= (+ a c) b))]
    (and greater-than-zero compare-three-sides)))

(defn equilateral?
  "Returns true if the triangle with sides a, b, and c is equilateral; otherwise, returns false"
  [a b c]
  (if (triangle? a b c) ;;Check if the shape is triangle at all or not
    (if (= a b c)
      true
      false)
    false))

(defn isosceles?
  "Returns true if the triangle with sides a, b, and c is isosceles; otherwise, returns false"
  [a b c]
  (if (triangle? a b c)
    (if (or (= a b)
            (= b c)
            (= c a))
      true
      false)
    false))

(defn scalene?
  "Returns true if the triangle with sides a, b, and c is scalene; otherwise, returns false"
  [a b c]
  (if (triangle? a b c)
    (if (and (not (= a b))
             (not (= b c))
             (not (= c a)))
      true
      false)
    false))


(. System (nanoTime))