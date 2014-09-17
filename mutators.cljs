(ns text-tube.mutators)

(defn split-by-line [text]
  "Splits "
  (clojure.string/split-lines text)
  )