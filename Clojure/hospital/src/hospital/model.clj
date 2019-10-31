(ns hospital.model)

(def empty-queue clojure.lang.PersistentQueue/EMPTY)

(def new-hospital
  :doctors empty-queue
  :exams empty-queue
  :nurses empty-queue
  :ticket-window empty-queue)


