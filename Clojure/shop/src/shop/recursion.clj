(ns shop.recursion)
; recursion, if we have a large element like an array with range 10000 this cause stackoverflow error
(defn my-map
  [function sequence]
  (let [firsElement (first sequence)]
    (if firsElement
      (do
        (function firsElement)
        (my-map function (rest sequence))))))

;tail recursion
(defn my-map
  [function sequence]
  (let [firsElement (first sequence)]
    (if firsElement
      (do
        (function firsElement)
        (recur function (rest sequence))))))                ;JIT transform in loop

