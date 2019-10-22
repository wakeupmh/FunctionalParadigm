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

;nested

(def demand {:backpack {:quantity 4 :price 80}
             :t-shirt {:quantity 5 :price 40}})

(assoc demand :keychain {:quantity 3 :price 15})

(println (demand :backpack))                                ;map as a function (if doesnt exists demand throw exception)
(println (get demand :backpack))                            ;get method
(println (get demand :chair))                               ;nil
(println (get demand :chair {}))                            ;default value {}
(println (:chair demand {}))                                ;as a get or map as fuction with default value
(println (:chair demand))

; THREADING
(println (:quantity (:backpack demand)))
(println (update-in demand [:backpack :quantity] inc))      ;update nested maps

(println (-> demand
             :backpack 
             :quantity))





