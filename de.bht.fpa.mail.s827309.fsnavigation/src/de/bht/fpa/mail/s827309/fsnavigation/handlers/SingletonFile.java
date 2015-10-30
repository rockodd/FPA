package de.bht.fpa.mail.s827309.fsnavigation.handlers;

import java.util.Observable;

/**
 * Observer, welcher auf Aktuallisierung des Pfades wartet, wenn neuer Pfad im
 * Getter �bergeben wurde, werden die Observer
 */
public final class SingletonFile extends Observable {
  private String path;

  private SingletonFile() {

  }

  private static SingletonFile instance = new SingletonFile();

  public static SingletonFile getInstance() {
    return instance;
  }

  /**
   * Setter, um Pfad zu �bergeben.
   */
  public void setpath(String path) {

    this.path = path;
    setChanged();

    // dem Observer muss der Pfad mit �bergeben werden
    notifyObservers(path);
  }

  /**
   * Getter,liefert gesetzten Pfad zur�ck.
   */
  public String getpath() {
    return path;
  }

}