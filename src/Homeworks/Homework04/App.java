package Homeworks.Homework04;

import java.util.Random;

public class App {
    public static void main(String[] args)
    {
        TeleVisor kitchenTV = new TeleVisor(); // Используем конструктор по умолчанию
        TeleVisor hallTV    = new TeleVisor( "ТВ в холле"   , "Samsung" , "SWE5507" , "GDT325487A08"   , 55 ); // Используем конструктор с параметрами
        TeleVisor bedroomTV = new TeleVisor( "ТВ в спальне" , "Sony"    , "SQ15"    , "QQS35R349F1437" , 32 ); // Используем конструктор с параметрами
        TeleVisor otherTV   = new TeleVisor( "Какой-то ТВ" ); // Используем конструктор с именем

        System.out.println( "Телевизор \"" + kitchenTV.getName() + "\" марки \"" + kitchenTV.getManufacture() + "\"" );
        System.out.println( "Телевизор \"" + hallTV.getName()    + "\" марки \"" + hallTV.getManufacture()    + "\"" );
        System.out.println( "Телевизор \"" + bedroomTV.getName() + "\" марки \"" + bedroomTV.getManufacture() + "\"" );
        System.out.println( "Телевизор \"" + otherTV.getName()   + "\" марки \"" + otherTV.getManufacture()   + "\"" );
        System.out.println( "" );
        System.out.println( "" );


        /* ------------------------------- На кухне ------------------------------- */

        System.out.println( "== Телевизор \"" + kitchenTV.getName() + "\" ==" );
        System.out.println( "" );

        System.out.println( "# Включаем #" );
        kitchenTV.turnOn();
        System.out.println( "" );

        System.out.println( "# Поиск каналов #" );
        kitchenTV.channelSeek();
        System.out.println( "" );

        System.out.println( "# Выбираем 5 канал по счёту #" );
        kitchenTV.setChannel( 5 );
        System.out.println( "" );

        System.out.println( "# Выставляем громкость на 66% #" );
        kitchenTV.setVolume( 66 );
        System.out.println( "" );

        System.out.println( "# Запрашиваем информацию #" );
        kitchenTV.info();
        System.out.println( "" );

        System.out.println( "# Запрашиваем статус #" );
        kitchenTV.status();
        System.out.println( "" );
        System.out.println( "" );


        /* ------------------------------- В спальне ------------------------------- */

        System.out.println( "== Телевизор \"" + bedroomTV.getName() + "\" ==" );
        System.out.println( "" );

        System.out.println( "# Включаем #" );
        bedroomTV.turnOn();
        System.out.println( "" );

        System.out.println( "# Поиск каналов #" );
        bedroomTV.channelSeek();
        System.out.println( "" );

        System.out.println( "# Выбираем 8 канал по счёту #" );
        bedroomTV.setChannel( 8 );
        System.out.println( "" );

        System.out.println( "# Выбираем следующий по счету канал #" );
        bedroomTV.channelNext();
        System.out.println( "" );

        System.out.println( "# Выставляем громкость на 100% #" );
        bedroomTV.setVolume( 100 );
        System.out.println( "" );

        System.out.println( "# Пытаемся увеличить громкость #" );
        bedroomTV.volumeUp();
        System.out.println( "" );

        System.out.println( "# Запрашиваем информацию #" );
        bedroomTV.info();
        System.out.println( "" );

        System.out.println( "# Запрашиваем статус #" );
        bedroomTV.status();
        System.out.println( "" );
        System.out.println( "" );


        /* ------------------------------- В холле ------------------------------- */

        System.out.println( "== Телевизор \"" + hallTV.getName() + "\" ==" );
        System.out.println( "" );

        System.out.println( "# Включаем #" );
        hallTV.turnOn();
        System.out.println( "" );

        System.out.println( "# Выбираем 8 канал по счёту #" );
        hallTV.setChannel( 8 );
        System.out.println( "" );

        System.out.println( "# Поиск каналов #" );
        hallTV.channelSeek();
        System.out.println( "" );

        System.out.println( "# Выбираем 8 канал по счёту #" );
        hallTV.setChannel( 8 );
        System.out.println( "" );

        System.out.println( "# Выставляем максимальную громкость #" );
        hallTV.volumeMax();
        System.out.println( "" );

        System.out.println( "# Пытаемся увеличить громкость #" );
        hallTV.volumeUp();
        System.out.println( "" );

        System.out.println( "# Запрашиваем информацию #" );
        hallTV.info();
        System.out.println( "" );

        System.out.println( "# Запрашиваем статус #" );
        hallTV.status();
        System.out.println( "" );
        System.out.println( "" );


        /* ------------------------------- Другой ------------------------------- */

        System.out.println( "== Телевизор \"" + otherTV.getName() + "\" ==" );
        System.out.println( "" );

        System.out.println( "# Выбираем 8 канал по счёту #" );
        otherTV.setChannel( 8 );
        System.out.println( "" );

        System.out.println( "# Включаем телевизор посреди ночи #" );
        otherTV.turnOnAndMute();
        System.out.println( "" );

        System.out.println( "# Поиск каналов #" );
        otherTV.channelSeek();
        System.out.println( "" );

        System.out.println( "# Выбираем предидущий канал по счёту #" );
        otherTV.channelPrev();
        System.out.println( "" );

        System.out.println( "# Выставляем громкость как на телевизоре в холле #" );
        otherTV.setVolume( hallTV );
        System.out.println( "" );

        System.out.println( "# Запрашиваем статус #" );
        otherTV.status();
        System.out.println( "" );

        System.out.println( "# Сбрасываем настройки #" );
        otherTV.resetToFactorySettings();
        System.out.println( "" );

        System.out.println( "# Запрашиваем статус #" );
        otherTV.status();
        System.out.println( "" );

        System.out.println( "# Выключаем телевизор #" );
        otherTV.turnOff();
        System.out.println( "" );

        System.out.println( "# Запрашиваем статус #" );
        otherTV.status();
        System.out.println( "" );

        System.out.println( "# Запрашиваем информацию #" );
        otherTV.info();
        System.out.println( "" );
        System.out.println( "" );
    }
}

class TeleVisor {
    private String name;
    private String manufacture;
    private String model;
    private String serialnumber;
    private int screenSize;
    private boolean isOn;
    private boolean mute = false;
    private int channel;
    private int channels;
    private int volume; // 1-100

    // Конструктор по умолчанию
    public TeleVisor() {
        this.name = "Noname";
        this.manufacture = "Unknown";
        this.model = "Unknown";
        this.serialnumber = "";
        this.screenSize = 24;
        this.isOn = false;
        this.mute = false;
        this.channel = 0;
        this.volume = 50;
    }

    // Конструктор только с именем
    public TeleVisor( String name ) {
        this.name = name;
        this.manufacture = "Unknown";
        this.model = "Unknown";
        this.serialnumber = "";
        this.screenSize = 24;
        this.isOn = false;
        this.mute = false;
        this.channel = 0;
        this.volume = 50;
    }

    // Конструктор с параметрами
    public TeleVisor( String name , String manufacture , String model , String serialnumber , int screenSize ) {
        this.name = name;
        this.manufacture = manufacture;
        this.model = model;
        this.serialnumber = serialnumber;
        this.screenSize = screenSize;
        this.isOn = false;
        this.mute = false;
        this.channel = 0;
        this.volume = 50;
    }

    /* Геттеры и сеттеры для свойств */

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    // Геттеры и сеттеры для свойств
    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture( String manufacture ) {
        this.manufacture = manufacture;
    }

    public String getModel() {
        return model;
    }

    public void setModel( String model ) {
        this.model = model;
    }

    public String getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber( String serialnumber ) {
        this.serialnumber = serialnumber;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    public boolean isMute() {
        return mute;
    }

    public void setMute( boolean m ) {
        this.mute = m;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel( int channel ) {
        if ( isOn ) {
            if ( channels == 0 ) {
                System.out.println( "Каналы не настроены. Сначала надо запустить поиск каналов" );
            } else {
                if ( ( channel <= channels ) && ( channel > 0 ) ) {
                    this.channel = channel;
                }
                System.out.println( "Выбран канал : " + this.channel );
            }
        } else {
            System.out.println(  "Устройство отключено, сначала его надо включить"  );
        }
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume( int volume ) {
        if ( isOn ) {
            if ( volume == 0 ) {
                this.mute = true;
                System.out.println( "Громкость не изменилась : " + this.volume );
                System.out.println( "Звук отключен" );
            } else {
                if ( ( volume < 101 ) && ( volume > 0 ) ) {
                    this.volume = volume;
                    System.out.println( "Громкость установлена : " + this.volume );
                } else {
                    System.out.println( "Не допустимое значение уровня громкости" );
                }
            }
        } else {
            System.out.println(  "Устройство отключено, сначала его надо включить"  );
        }
    }

    // Установить громкость как на указанном телевизоре
    public void setVolume( TeleVisor tv ) {
        int volume = tv.getVolume();
        if ( isOn ) {
            this.volume = volume;
            System.out.println( "Громкость установлена : " + this.volume + " , такая же как на \"" + tv.getName() + "\"" );
        } else {
            System.out.println(  "Устройство отключено, сначала его надо включить"  );
        }
    }

    /* Методы */

    public boolean isOn() {
        return isOn;
    }

    public void setOn( boolean on ) {
        isOn = on;
    }

    // Включить телевизор
    public void turnOn() {
        this.isOn = true;
        System.out.println( "Телевизор \"" + this.name + "\" включили" );
    }

    // Включить телевизор с отключенным звуком
    public void turnOnAndMute() {
        this.mute = true;
        this.isOn = true;
        System.out.println( "Телевизор \"" + this.name + "\" включили с отключенным звуком" );
    }

    // Выключить телевизор
    public void turnOff() {
        this.isOn = false;
        System.out.println( "Телевизор \"" + this.name + "\" выключили" );
    }

    public void channelNext() {
        if ( isOn ) {
            if ( channels == 0 ) {
                System.out.println( "Каналы не настроены. Сначала надо запустить поиск каналов" );
            } else {
                if ( this.channel < this.channels ) { this.channel++; } else { this.channel = 1; }
                System.out.println( "Выбран канал : " + this.channel );
            }
        } else {
            System.out.println(  "Устройство отключено, сначала его надо включить"  );
        }
    }

    public void channelPrev() {
        if ( isOn ) {
            if ( channels == 0 ) {
                System.out.println( "Каналы не настроены. Сначала надо запустить поиск каналов" );
            } else {
                if ( this.channel > 1 ) { this.channel--; } else { this.channel = this.channels; }
                System.out.println( "Выбран канал : " + this.channel );
            }
        } else {
            System.out.println( "Устройство отключено, сначала его надо включить" );
        }
    }

    public void channelSeek() {
        Random random = new Random();

        if ( isOn ) {
            this.channels = random.nextInt(190 ) + 10;
            this.channel = 1;
            System.out.println( "Найдено " + this.channels + " каналов" );
            System.out.println( "Выбран канал : " + this.channel );
        } else {
            System.out.println( "Устройство отключено, сначала его надо включить" );
        }
    }

    public void volumeUp() {
        if ( isOn ) {
            if (this.volume < 100) {
                this.volume++;
                System.out.println( "Громкость увеличена : " + this.volume );
            } else {
                System.out.println( "Громкость больше нельзя увеличить : " + this.volume );
            }
        } else {
            System.out.println( "Устройство отключено, сначала его надо включить" );
        }
    }

    public void volumeDown() {
        if ( isOn ) {
            if ( this.volume > 1 ) {
                this.volume--;
                System.out.println( "Громкость уменьшена : " + this.volume );
            } else {
                System.out.println( "Громкость нельзя уменьшить ещё : " + this.volume );
            }
        } else {
            System.out.println( "Устройство отключено, сначала его надо включить" );
        }
    }

    public void volumeMin() {
        if ( isOn ) {
            this.volume = 1;
            System.out.println( "Минимальная громкость : " + this.volume );
        } else {
            System.out.println( "Устройство отключено, сначала его надо включить" );
        }
    }

    public void volumeMax() {
        if ( isOn ) {
            this.volume = 100;
            System.out.println( "Максимальная громкость : " + this.volume );
        } else {
            System.out.println( "Устройство отключено, сначала его надо включить" );
        }
    }

    // Сброс настроек в заводские
    public void resetToFactorySettings() {
        if ( isOn ) {
            this.channels = 0;
            this.channel = 0;
            this.volume = 50;
            this.mute = false;
            System.out.println( "Настройки сбошены в заводские" );
        } else {
            System.out.println( "Устройство отключено, сначала его надо включить" );
        }
    }

    public void info() {
        System.out.println( "Имя                : " + this.name         );
        System.out.println( "Производитель      : " + this.manufacture  );
        System.out.println( "Модель             : " + this.model        );
        System.out.println( "Серийный номерИмя  : " + this.serialnumber );
        System.out.println( "Диагональ (дюймов) : " + this.screenSize   );
    }

    public void status() {
        if ( isOn ) {
            System.out.println( "Телевизор \"" + this.name + "\" включен" );
            if ( this.channels == 0 ) {
                System.out.println( "Каналы не настроены" );
            } else {
                System.out.println( "Настроено каналов : " + this.channels );
                System.out.println( "Выбран канал      : " + this.channel );
            }
            System.out.println( "Громкость         : " + this.volume );
            if ( mute ) {
                System.out.println( "Звук              : отключен" );
            } else {
                System.out.println( "Звук              : включен" );
            }
        } else {
            System.out.println( "Телевизор \"" + this.name + "\" выключен" );
        }
    }
}
