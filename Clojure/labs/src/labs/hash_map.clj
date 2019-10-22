(ns labs.hash-map)
(def store {"Backpack" 10, "T-shirt" 5})

(println "We have" (count store))
(println "The keys are" (keys store))
(println "The values are" (vals store))

; keyword -> :backpack

(def store {:backpack 10, :t-shirt 5})

(println (assoc store :chair 3))

(println (update store :backpack inc))

(defn remove-1
  [value]
  (- value 1))
(println (update store :backpack remove-1))
(println (update store :backpack #(- % 2)))

(println (dissoc store :t-shirt))