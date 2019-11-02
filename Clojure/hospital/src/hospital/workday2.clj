(ns hospital.workday2
  :use
  [clojure.pprint]
  :require
  [hospital.business :as h.business]
  [hospital.model :as h.model]
  (:require [hospital.model :as h.model]))

(defn big-atom []
  (let [hospital-lima (atom {:wait h.model/empty-queue})]
    (pprint hospital-lima)
    (pprint (deref hospital-lima));extract a value in atom
    (pprint @hospital-lima);extract a value in atom

    (pprint (assoc @hospital-lima :exams h.model/empty-queue)) ;doesn't change the value, jus add a value into a clone
    ;!-> refers to side effect
    (swap! hospital-lima assoc :exams h.model/empty-queue) ;Change the value of an atom, side effect.....
    (pprint @hospital-lima)

    ;update a value without side effect, using deref
    (update @hospital-lima :exams conj "111")

    ;with side effects
    (swap! hospital-lima update :exams conj "111")
    (pprint @hospital-lima)
    

    ))
